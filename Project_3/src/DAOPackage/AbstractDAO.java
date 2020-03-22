package dao_package;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionClass;

public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;

	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public String createSelectQ(String field) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" WHERE " + field + " =?");
		return stringBuilder.toString();
	}

	public String createSelectAllQ() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM ");
		stringBuilder.append(type.getSimpleName());
		return stringBuilder.toString();
	}

	public String createInsertQ() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" VALUES (");
		for (int i = 0; i < type.getDeclaredFields().length - 1; i++) {
			stringBuilder.append(" ? , ");
		}
		stringBuilder.append(" ? )");
		return stringBuilder.toString();
	}

	public String createUpdateQ(String field1, String field2) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UPDATE ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" SET ");
		stringBuilder.append(field1 + " =? ");
		stringBuilder.append(" WHERE " + field2 + " =?");
		return stringBuilder.toString();
	}

	public String createDeleteQ(String field) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DELETE FROM ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" WHERE " + field + " =?");
		return stringBuilder.toString();
	}

	public T findByID(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQ(type.getDeclaredFields()[0].getName());
		try {
			connection = ConnectionClass.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.first() == false) {
				return null;
			}
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById" + e.getMessage());
		} finally {
			ConnectionClass.closeResultSet(resultSet);
			ConnectionClass.closePreparedStatement(statement);
			ConnectionClass.closeConnection(connection);
		}
		return null;
	}

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>(1);
		try {
			if (resultSet.first()) {
				do {
					T instance = type.newInstance();
					for (Field field : type.getDeclaredFields()) {
						Object value = resultSet.getObject(field.getName());
						PropertyDescriptor propertyDescript = new PropertyDescriptor(field.getName(), type);
						Method method = propertyDescript.getWriteMethod();
						method.invoke(instance, value);
					}
					list.add(instance);
				} while (resultSet.next());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SQLException | IntrospectionException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:createObjects: " + e.getMessage());
		}
		return list;
	}

	public void addObject(T tObject) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQ();
		try {
			connection = ConnectionClass.getConnection();
			statement = connection.prepareStatement(query);
			int i = 1;
			for (Field field : type.getDeclaredFields()) {
				PropertyDescriptor propertyDescript = new PropertyDescriptor(field.getName(), type);
				Method method = propertyDescript.getReadMethod();
				Object value = method.invoke(tObject);
				statement.setObject(i, value);
				i++;
			}
			statement.executeUpdate();
		} catch (IllegalArgumentException | IllegalAccessException | SQLException | InvocationTargetException
				| IntrospectionException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:addObject: " + e.getMessage());
		} finally {
			ConnectionClass.closePreparedStatement(statement);
			ConnectionClass.closeConnection(connection);
		}
	}

	public void updateField(String fieldNewValue, String fieldCond, Object o1, Object o2) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQ(fieldNewValue, fieldCond);
		try {
			connection = ConnectionClass.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, o1);
			statement.setObject(2, o2);
			statement.executeUpdate();
		} catch (IllegalArgumentException | SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:updateField: " + e.getMessage());
		} finally {
			ConnectionClass.closePreparedStatement(statement);
			ConnectionClass.closeConnection(connection);
		}
	}

	public void deleteObjectByID(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createDeleteQ(type.getDeclaredFields()[0].getName());
		try {
			connection = ConnectionClass.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById: " + e.getMessage());
		} finally {
			ConnectionClass.closePreparedStatement(statement);
			ConnectionClass.closeConnection(connection);
		}
	}

	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAllQ();
		try {
			connection = ConnectionClass.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll: " + e.getMessage());
		} finally {
			ConnectionClass.closeResultSet(resultSet);
			ConnectionClass.closePreparedStatement(statement);
			ConnectionClass.closeConnection(connection);
		}
		return Collections.emptyList();
	}
}
