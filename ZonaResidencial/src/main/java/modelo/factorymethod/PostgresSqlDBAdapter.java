package modelo.factorymethod;

import java.sql.Connection;


/**
 * 
 */
public class PostgresSqlDBAdapter implements IDBAdapter {

    /**
     * Default constructor
     */
    public PostgresSqlDBAdapter() {
    }

    /**
     * @return
     */
    public Connection getConnection() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String createConnectionString() {
        // TODO implement here
        return "";
    }

}