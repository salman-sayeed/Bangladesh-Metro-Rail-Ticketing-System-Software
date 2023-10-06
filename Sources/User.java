//user parent class
package Sources;
public class User{
private String U_name;
private String U_pass;
public User(String U_name,String U_pass){
    this.U_name=U_name;
    this.U_pass=U_pass;
}
public String getU_name(){return U_name;}
public String getU_pass(){return U_pass;}
}