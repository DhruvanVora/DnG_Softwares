import java.sql.*;

class JDBC_Connection{

    Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/DnG_softwares", "dhruvan", "Dhr@1606");

    JDBC_Connection() throws SQLException {
    }

  public boolean createUser(String username, String email) {

      boolean isCreate = false;
      try {

          PreparedStatement stmt = con.prepareStatement("insert into users (username, email) values (?,?)");


          stmt.setString(1, username);
          stmt.setString(2, email);
          isCreate = stmt.execute();
          System.out.println(username+" Aunty ji khul gya khata.");

      } catch (Exception e) {
          System.out.println(e);
      }
      return isCreate;
  }

   public boolean logIn(String username) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from users where username = ?");
        stmt.setString(1, username);
       ResultSet rs = stmt.executeQuery();
       rs.next();
        if(username.equals(rs.getString("username"))){
            System.out.println(rs.getString("username") + " , Swagat hai Aunty ji.");
            return true;
        }
        else {
            return false;
        }

    }


    public int updateHighScore(int score, String username) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select high_score from users where username = ?");

        stmt.setString(1, username);
        ResultSet rs1 = stmt.executeQuery();
        rs1.next();
        int rs_1 = rs1.getInt("high_score");
        if(rs_1 < score){
            PreparedStatement one = con.prepareStatement("update users set high_score = ? where username = ?");

            one.setInt(1, score);
            one.setString(2, username);
            boolean isUpdated = one.execute();
        }
        con.close();
        return Math.max(rs_1, score);
    }





}
