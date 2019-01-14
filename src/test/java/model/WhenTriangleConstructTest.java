package model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WhenTriangleConstructTest {
    @Parameterized.Parameter(0)
    public double firstSide;
    @Parameterized.Parameter(1)
    public double secondSide;
    @Parameterized.Parameter(2)
    public double thirdSide;
    @Parameterized.Parameter(3)
    public boolean expectException;


    @Parameterized.Parameters(name = "testTriangleConditionValidated{index}: side1={0}, side2={1}, side3={2}" )
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 2, 5, true}
                , {2, 5, 2, true}
                , {5, 2, 2, true}
                , {3, 2, 3, false}
        });
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testTriangleConditionValidated() {
        if (expectException) {
            exceptionRule.expect(IllegalArgumentException.class);
        }
        Triangle.builder()
                .firstSide(firstSide)
                .secondSide(secondSide)
                .thirdSide(thirdSide)
                .build();
    }
}
