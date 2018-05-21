package tests;

public class Test {

    public static void main(String[] args) {
        TestHasher testHasher = new TestHasher();
        TestPlanner testPlanner = new TestPlanner();
        TestSportBuilder testSportBuilder = new TestSportBuilder();
        TestTrainingDay testTrainingDay = new TestTrainingDay();
        TestUserInfo testUserInfo = new TestUserInfo();
        TestSQLCommunication testSQL = new TestSQLCommunication();

        testHasher.test();
        testPlanner.test();
        testSportBuilder.test();
        testTrainingDay.test();
        testUserInfo.test();
        testSQL.test();
    }
}
