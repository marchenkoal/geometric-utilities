package model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Triangle {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;
    private TriangleType triangleType;

    @Builder
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        validateTriangleSideLengths();
    }

    private void validateTriangleSideLengths() {
        boolean triangularConditionSatisfied = firstSide < secondSide + thirdSide
                && secondSide < firstSide + thirdSide
                && thirdSide < firstSide + secondSide;
        if (!triangularConditionSatisfied) {
            throw new IllegalArgumentException("Triangle side lengths are invalid: " +
                    "The sum of the lengths of any two sides must be greater than the length of the third party.");
        }
    }

    public TriangleType getTriangleType() {
        if (triangleType == null) {
            triangleType = evluateTriangleTypeProperty();
        }
        return triangleType;
    }

    private TriangleType evluateTriangleTypeProperty() {
        boolean firstSideEqualsSecondSide = firstSide == secondSide;
        boolean secondSideEqualsThirdSide = secondSide == thirdSide;

        if (firstSideEqualsSecondSide && secondSideEqualsThirdSide) {
            return TriangleType.equilateral;
        }

        if (firstSideEqualsSecondSide || secondSideEqualsThirdSide || firstSide == thirdSide) {
            return TriangleType.isosceles;
        }
        return TriangleType.scalene;
    }
}
