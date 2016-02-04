package basic;

/**
 * Created by root on 13/12/15.
 *
 * Following is a recap of the algorithm discussed in the previous post.

    1) We sort all points according to x coordinates.

    2) Divide all points in two halves.

    3) Recursively find the smallest distances in both sub-arrays.

    4) Take the minimum of two smallest distances. Let the minimum be d.

    5) Create an array strip[] that stores all points which are at most d distance
        away from the middle line dividing the two sets.

    6) Find the smallest distance in strip[].

    7) Return the minimum of d and the smallest distance calculated in above step 6.

 *
 *
 */
public class M02BClosetPairProblem {
}
