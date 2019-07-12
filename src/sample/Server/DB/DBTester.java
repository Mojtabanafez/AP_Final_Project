package sample.Server.DB;


public class DBTester  {

    public static void main(String[] args) {
        Group group = new Group();
        group.setName("CE Engineering 4");
        GroupManager groupManager =new GroupManager();
        // groupManager.Insert(group);
        // groupManager.Delete(1);
        Group newGroup = new Group();
        newGroup.setId(3);
        newGroup.setName("Electrical Engineering");
        groupManager.Upadate(newGroup);
        System.out.println(groupManager.getGroup(3));

        //  MassageManager massageManager = new MassageManager();
        // System.out.println(massageManager.getAllMassage());
      /*  Massage massage =new Massage();
        UserManager userManager = new UserManager();
        massage.setUser(userManager.getUser(13));
        massage.setDate("1988/05/04");
        massage.setText("sfdhjhjfklds;kajfjkldsa\nsdfsfd");
        massageManager.Insert(massage);
        //massageManager.Delete(1);
        //System.out.println(massageManager.getMassage(3));
*/
/*
        Massage newMassage = massageManager.getMassage(4);
        newMassage.setText("In THe name Of God");
        massageManager.Update(newMassage);
        List<Massage>massages= massageManager.getAllMassage();
        for(Massage a: massages)
            System.out.println(a);
        // Example for UserManager:
      */
        /*User user =new User();
        user.setPassword("46511");
        user.setEmail("sfjdk@gmail.com");
        user.setName("Ali");
        user.setLastName("Mohammadi");
        user.setUserName("mamad");
        user.setProfileAddress("C:Descktop");
        UserManager userManager = new UserManager();
        userManager.Insert(user);
        //userManager.Delete(4);
        //System.out.println(userManager.getUser(2));
*/
      /*  User newUser = userManager.getUser(2);
        newUser.setName("Mamad Jangi");
        userManager.Update(newUser);
*/


        // List<User> userList =userManager.getAllUser();
        // for(User a: userList)
        //     System.out.println(a);

    }
}
