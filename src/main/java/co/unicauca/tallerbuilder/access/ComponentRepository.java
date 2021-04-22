package co.unicauca.tallerbuilder.access;

import co.unicauca.tallerbuilder.dominio.Component;
import co.unicauca.tallerbuilder.dominio.EnumComponent;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Libardo, Julio
 */
public class ComponentRepository implements IComponentRepository {

    private Connection conn;

    public ComponentRepository() {
        initDatabase();
    }

    @Override
    public boolean saveComponent(Component component) {

        try {
            //Validate product
            if (component == null || component.getId() < 0 || component.getName().isEmpty()) {
                return false;
            }
            this.connect();

            String sql = "INSERT INTO Component (id, name, price, type ) "
                    + "VALUES ( ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, component.getId());
            pstmt.setString(2, component.getName());
            pstmt.setDouble(3, component.getPrice());
            pstmt.setString(4, component.getType().toString());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Component> getComponents() {
        ArrayList<Component> components = new ArrayList<>();
        try {

            String sql = "SELECT id, name, price, type FROM Component";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Component component = new Component();
                component.setId(rs.getInt("id"));
                component.setName(rs.getString("name"));
                component.setPrice(rs.getInt("price"));
                component.setType(EnumComponent.valueOf(rs.getString("type")));

                components.add(component);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return components;
    }
    
    @Override
    public Component findComponent(int id) {

        Component component = null;
        try {

            String sql = "SELECT id, name, price, type FROM Component WHERE id = ?";
            this.connect();

            PreparedStatement pstmt  = conn.prepareStatement(sql);
            
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();

           
            while (rs.next()) {
                component = new Component();
                component.setId(rs.getInt("id"));
                component.setName(rs.getString("name"));
                component.setPrice(rs.getInt("price"));
                component.setType(EnumComponent.valueOf(rs.getString("type")));
            };
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return component;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Component (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	price integer,\n"
                + "	type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:./tallerbuilderdb.db";
        //String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
