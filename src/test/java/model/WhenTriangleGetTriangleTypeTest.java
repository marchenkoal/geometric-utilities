package model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WhenTriangleGetTriangleTypeTest {

    @Parameterized.Parameter(0)
    public double firstSide;
    @Parameterized.Parameter(1)
    public double secondSide;
    @Parameterized.Parameter(2)
    public double thirdSide;
    @Parameterized.Parameter(3)
    public TriangleType expectedTriangularType;


    @Parameterized.Parameters(name = "testGetTriangularType{index}: side1={0}, side2={1}, side3={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3.01, 3.01, 3.01, TriangleType.equilateral}
                , {3.01, 3.01, 2.0, TriangleType.isosceles}
                , {3.01, 2.0, 3.01, TriangleType.isosceles}
                , {2.0, 3.01, 3.01, TriangleType.isosceles}
                , {3.0, 2.01, 1.50, TriangleType.scalene}
        });
    }

    @Test
    public void testGetTriangularType() {

        Triangle triangle = Triangle.builder()
                .firstSide(firstSide)
                .secondSide(secondSide)
                .thirdSide(thirdSide)
                .build();

        assertEquals(expectedTriangularType, triangle.getTriangleType());
    }
}
