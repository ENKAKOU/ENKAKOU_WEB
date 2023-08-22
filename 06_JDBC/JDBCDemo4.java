
public class JDBCDemo4 {

	public void demo1(){
		UserDao userDao = new UserDao();
		boolean flag = userDao.login("aaa' -- ", "qweqwersdfsd");
		if(flag){
			System.out.println("登录成功!");
		}else{
			System.out.println("登录失败!");
		}

		class UserDao {

			public boolean login(String username, String password) {
				return false;
			}
		}

	}
}
