/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

 class HNode {

        int m;
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    }




 class MedianOfArray {

  

    public static int getMedian(int e, HNode node) {

        int m = node.m;

        PriorityQueue<Integer> left = node.left;

        PriorityQueue<Integer> right = node.right;

        int leftSize = left.size();


        int rightSize = right.size();
        System.out.println("left size :: "+ leftSize + "  :: rightsize " + rightSize);

        int compare = compare(leftSize, rightSize);


//left has more elements than right
//
//        if (compare < 0) {
//
//            compare = -1;
//
//        }
//
//        if (compare > 0) {
//
//            compare = 1;
//
//        }

        switch (compare) {

            case 1:// There are more elements in left (max) heap

                if (e < m)// current element fits in left (max) heap
                {

// Remore top element from left heap and

// insert into right heap

                    if (!left.isEmpty()) {

                        right.add(left.poll());

                    }

// current element fits in left (max) heap

                    left.add(e);

                } else {

// current element fits in right (min) heap

                    right.add(e);

                }

// Both heaps are balanced

                node.m = (left.peek() + right.peek()) / 2;

                break;

            case -1:// There are more elements in right (min) heap

                if (e < m)// current element fits in left (max) heap
                {

                    left.add(e);

                } else {

// Remove top element from right heap and

// insert into left heap

                    if (!right.isEmpty()) {

                        left.add(right.poll());

                    }

// current element fits in right (min) heap

                    right.add(e);

                }

// Both heaps are balanced

                node.m = (left.peek() + right.peek()) / 2;

                break;

            case 0:

                if (e < m) {

// current element fits in left (max) heap

                    left.add(e);

                    node.m = left.peek();

                } else {

// current element fits in right (min) heap

                    right.add(e);

                    node.m = right.peek();

                }

                break;

        }

        return node.m;

    }

 public static int inputFromUser() throws IOException
{
  System.out.println("input from user :: ");
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int len = Integer.valueOf(br.readLine()).intValue();
   return len;
}


    public static void main(String[] args) throws IOException {

        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        HNode node = new HNode();

        node.m = 0;

        Comparator<Integer> reverse = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o2.compareTo(o1);

            }
        };

        Comparator natural = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o1.compareTo(o2);

            }
        };

        node.left = new PriorityQueue<Integer>(100000, reverse);

        node.right = new PriorityQueue<Integer>(100000, natural);

        for (int i=0;i<A.length;i++) {

            int m = getMedian(A[i], node);

            System.out.println(m);

        }

    }



             public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}

