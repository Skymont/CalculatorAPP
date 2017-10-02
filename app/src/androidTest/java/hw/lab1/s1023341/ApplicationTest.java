package hw.lab1.s1023341;

import android.app.Application;
import android.test.ApplicationTestCase;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super(MainActivity.class);
    }
    private Solo solo;

    //Setting
    @Override
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation() , getActivity());
    }
    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

    //test
    public void testBasicAdd() throws Exception{
        //492 285 +=    ans:777
        solo.unlockScreen();
        solo.clickOnButton("4");
        solo.clickOnButton("9");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("8");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("+");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean answerFound = solo.searchText("777");
        assertTrue("Answer Add error" , answerFound);
    }

    public void testBasicSub() throws Exception{
        //5 6 -=    ans:-1
        solo.unlockScreen();
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean answerFound = solo.searchText("-1");
        assertTrue("Test Sub error" , answerFound);
    }

    public void testBasicMul() throws Exception{
        //89 57 *=  ans:5073
        solo.unlockScreen();
        solo.clickOnButton("8");
        solo.clickOnButton("9");
        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean answerFound = solo.searchText("5073");
        assertTrue("Test Mul error" , answerFound);
    }

    public void testBasicDiv() throws Exception{
        //731 256 /=    ans:2.85546875
        solo.unlockScreen();
        solo.clickOnButton("7");
        solo.clickOnButton("3");
        solo.clickOnButton("1");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("5");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean answerFound = solo.searchText("2.85546875");
        assertTrue("Test Div1 error" , answerFound);
    }

    public void testBasicDiv2() throws Exception{
        //731 0 /=  ans:Wrong Input
        solo.unlockScreen();
        solo.clickOnButton("7");
        solo.clickOnButton("3");
        solo.clickOnButton("1");
        solo.clickOnButton("Space");
        solo.clickOnButton("0");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean answerFound = solo.searchText("Input Error");
        assertTrue("Test Div2 error" , answerFound);
    }

    public void testDul2Oct2Dec() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("Dul");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("Oct");
        solo.takeScreenshot();
        boolean ans1 = solo.searchText("12");
        assertTrue("testDul2Oct2Dec error 1", ans1);

        solo.clickOnButton("Space");
        solo.clickOnButton("6");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("=");
        solo.takeScreenshot();
        boolean ans2 = solo.searchText("1022");
        assertTrue("testDul2Oct2Dec error 2", ans2);

        solo.clickOnButton("Dec");
        solo.takeScreenshot();
        boolean answerFound = solo.searchText("530");
        assertTrue("testDul2Oct2Dec error 3" , answerFound);
    }

    public void testDul2Dec2Oct() throws Exception{
        solo.clickOnButton("Dul");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("1");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("0");
        solo.clickOnButton("1");
        solo.clickOnButton("1");
        solo.clickOnButton("1");
        solo.clickOnButton("1");
        solo.clickOnButton("Oct");

        solo.takeScreenshot();
        boolean ans1 = solo.searchText("2895");
        assertTrue("testDul2Dec2Oct error 1", ans1);

        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton("Oct");
        solo.clickOnButton("/");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean ans2 = solo.searchText("579");
        assertTrue("testDul2Dec2Oct error 2", ans2);

        solo.clickOnButton("Oct");

        solo.takeScreenshot();
        boolean ans3 = solo.searchText("1103");
        assertTrue("testDul2Dec2Oct error 3", ans3);
    }

    public void testDec2DulSpOct2Dul() throws Exception{
        solo.clickOnButton("Dec");
        solo.clickOnButton("3");
        solo.clickOnButton("4");
        solo.clickOnButton("1");
        solo.clickOnButton("Dul");

        solo.takeScreenshot();
        boolean ans1 = solo.searchText("101010101");
        assertTrue("testDec2DulSpOct2Dul error 1", ans1);


        solo.clickOnButton("Space");
        solo.clickOnButton("Oct");
        solo.clickOnButton("Space");
        solo.clickOnButton("4");
        solo.clickOnButton("7");
        solo.clickOnButton("5");
        solo.clickOnButton("Dul");

        solo.takeScreenshot();
        boolean ans2 = solo.searchText("100111101");
        assertTrue("testDec2DulSpOct2Dul error 2", ans2);


        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");

        solo.takeScreenshot();
        boolean ans3 = solo.searchText("11000");
        assertTrue("testDec2DulSpOct2Dul error 3", ans3);
    }

    public void testPostfix1() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("4");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("8");
        solo.clickOnButton("Space");
        solo.clickOnButton("+");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("Space");
        solo.clickOnButton("4");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");

        solo.takeScreenshot();

        boolean ans = solo.searchText("-237");
        assertTrue("TestPostfix 1 error", ans);
    }

    public void testPostfix2() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("7");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("3");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("6");
        solo.clickOnButton("*");
        solo.clickOnButton("Space");
        solo.clickOnButton("8");
        solo.clickOnButton("3");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton("=");

        solo.takeScreenshot();

        boolean ans = solo.searchText("Input Error");
        assertTrue("TestPostfix 2 error", ans);
    }

    public void testPoint1() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("4");
        solo.clickOnButton(".");
        solo.clickOnButton("8");
        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton(".");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("+");
        solo.clickOnButton("Space");
        solo.clickOnButton("0");
        solo.clickOnButton(".");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("Space");
        solo.clickOnButton("8");
        solo.clickOnButton(".");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("Space");
        solo.clickOnButton("1");
        solo.clickOnButton(".");
        solo.clickOnButton("9");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");

        solo.takeScreenshot();

        boolean ans = solo.searchText("178.7");
        assertTrue("TestPoint 1 error", ans);
    }

    public void testPoint2() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("0");
        solo.clickOnButton(".");
        solo.clickOnButton(".");
        solo.clickOnButton("2");

        solo.takeScreenshot();

        boolean ans = solo.searchText("0.2");
        assertTrue("TestPoint 1 error", ans);
    }

    public void testScal1() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("N!");
        solo.clickOnButton("=");

        solo.takeScreenshot();

        boolean ans = solo.searchText("3628800");
        assertTrue("TestScal 1 error", ans);
    }

    public void testScal2() throws Exception {
        solo.unlockScreen();
        solo.clickOnButton("2");
        solo.clickOnButton("6");
        solo.clickOnButton("N!");
        solo.clickOnButton("=");

        solo.takeScreenshot();

        boolean ans = solo.searchText("403291461126605635584000000");
        assertTrue("TestScal 2 error", ans);
    }


}