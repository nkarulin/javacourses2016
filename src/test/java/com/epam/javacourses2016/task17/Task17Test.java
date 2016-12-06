package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by kodoo on 13.11.16.
 */

public class Task17Test {

    private final DecimalFormat format = new DecimalFormat("#.###");

    {
        format.setRoundingMode(RoundingMode.CEILING);
    }

    private boolean compareDoubles(double first, double second) {
        return format.format(first).equals(format.format(second));
    }

    @Test(enabled = false, dataProvider = "segmentsWithResults")
    public void testAnalyze(Segment[] segments, Set<Point2D> expected) throws Exception {
        SolverTask17 solver = new SolverTask17();
        Set<Point2D> result = solver.analyze(new HashSet<>(Arrays.asList(segments)));

        final DecimalFormat format = new DecimalFormat("#.###");
        format.setRoundingMode(RoundingMode.CEILING);
        Comparator<Point2D> comparator = (first, second) -> {
            if (first == null && second == null)
                return 0;
            else if (first == null)
                return -1;
            else if (second == null)
                return 1;

            double x1 = first.getX();
            double x2 = second.getX();
            double y1 = first.getX();
            double y2 = first.getY();

            boolean xEquals = compareDoubles(x1, x2);
            boolean yEquals = compareDoubles(y1, y2);
            return xEquals ? 0 : x1 > x2 ? 1 : -1;

        };

        Point2D[] expectedArr = expected.toArray(new Point2D[expected.size()]);
        Point2D[] resultArr = result.toArray(new Point2D[result.size()]);
        Arrays.sort(expectedArr, comparator);
        Arrays.sort(resultArr, comparator);
        for (int i = 0; i < resultArr.length; i++) {
            if (comparator.compare(expectedArr[i], resultArr[i]) != 0)
                Assert.fail();
        }
    }

    @DataProvider(name = "segmentsWithResults")
    public Object[][] segmentsWithResults() {
        return new Object[][]{

                {
                        new Segment[]{
                                new Segment(new Point2D(0, 0), new Point2D(14, 0)),
                                new Segment(new Point2D(-2, 2), new Point2D(3, 5))
                        }, new HashSet<Point2D>()
                },
                {
                        new Segment[]{new Segment(new Point2D(-3, -4), new Point2D(10, 10)),
                                new Segment(new Point2D(-5, 6), new Point2D(5, -4))},
                        new HashSet<>(new ArrayList<Point2D>() {{
                            this.add(new Point2D(((double) 23) / 27, ((double) 4) / 27));
                        }})
                },
                {
                        new Segment[]{
                                new Segment(new Point2D(-2, 4), new Point2D(2, 5)),
                                new Segment(new Point2D(2, 5), new Point2D(4, 0)),
                                new Segment(new Point2D(2, 2), new Point2D(3, 5)),
                                new Segment(new Point2D(-4, 0.5), new Point2D(2, 2)),
                                new Segment(new Point2D(0, 7), new Point2D(2.8, 0))
                        }, new HashSet<>(new ArrayList<Point2D>() {{
                    this.add(new Point2D(2, 2));
                    this.add(new Point2D(2, 5));
                }})
                },
                {
                        new Segment[]{
                                new Segment(new Point2D(0, 0), new Point2D(0, 14)),


                        }, new HashSet<>(new ArrayList<Point2D>() {{

                    this.add(new Point2D(0, 0));

                }})
                },
                {
                        new Segment[]{

                        }, new HashSet<>(new ArrayList<Point2D>() {{

                    this.add(new Point2D(0, 2));
                }})
                }

        };
    }

}