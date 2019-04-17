/**
 * author: haeram27@gmail.com
 * 
 * 문제> MostLargeSqure include some 0
 * 
 * 조건 1) 주어진 행렬안에서 가장 큰 Square(정사각형)을 찾아라.
 * 조건 2) Square는 0을 1개 이하로만 포함 할 수 있다. 
 * 조건 3) 조건1과 조건2를 만족하는 같은 크기의 정사각형이 여러 개 라면 
 *       가장 먼저 찾은 Square가 우선이고
 *       만약 여러 개 중 0이 없는 Square가 있다면 0이 없는 Square가 우선된다.
 * 조건 4) 출력할 값은 문제의 행렬에서 start point의 x,y값과 end point의 x,y 값이다.
 *       문제 행렬이 행16 열12의 배열이라면 
 *       가장 좌측의 최하단 위치의 좌표 (x,y)는 (1,1)이고 
 *       가장 우측의 최상단 위치의 좌표 (x,y)는 (16,12) 이다.
 * 조건 5) 실행완료 시간은 1초이내
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Square {
    int sx, sy, ex, ey;
    int holeCount;
    
    Square (int sx, int sy, int ex, int ey) {
        this.sx = sx;  // x of start point
        this.sy = sy;  // y of start point
        this.ex = ex;  // x of end point
        this.ey = ey;  // y of end point
    }
}

public class MostLargeSquare {    
    static void reverseRows(int[][] m) {
        int rowLen = m.length;
        int colLen = m[0].length;
        for (int i = 0; i < rowLen/2; ++i) {
            for (int j = 0; j < colLen; ++j) {
               int tmp = m[i][j];
               m[i][j] = m[rowLen-1-i][j];
               m[rowLen-1-i][j] = tmp;
            }
        }
    }

    static boolean checkHole(int[][] m, Square s) {
        int holeCount = 0;
        for (int i = s.sx; i <= s.ex; ++i) {
            for (int j = s.sy; j <= s.ey; ++j) {
                if (m[i][j] == 0) holeCount++;
                if (holeCount > 1) return false;
            }
        }
        s.holeCount = holeCount;
        return true;
    }
    
    static Square getMostLargeSquare(int[][] m) {
        int rowLen = m.length;
        int colLen = m[0].length;
        List<Square> candidates = new ArrayList<Square>();
        
        reverseRows(m);
        
        for (int off = Math.min(rowLen, colLen)-1; off > 0; --off) {
            for (int row = 0; row+off < rowLen; ++row) {
                for (int col = 0; col+off < colLen; ++col) {
                    Square s = new Square(row, col, row+off, col+off);
                    if (checkHole(m, s)) {
                        candidates.add(s);
                    }
                }
            }
            
            if (!candidates.isEmpty()) {
                candidates.sort(sComp);
                return candidates.get(0);
            }
        }
        
        return null;
    }
    
    static Comparator<Square> sComp = new Comparator<Square>() {
        @Override
        public int compare(Square o1, Square o2) {
            // TODO Auto-generated method stub
            return (o1.holeCount < o2.holeCount) ? -1 :
                ((o1.holeCount == o2.holeCount) ? 0 : 1);
        }
    };
    
    static void printSquareList(List<Square> l) {
        for (Square s : l) {
         // print start.x start.y end.x end.y holeCount
            System.out.println(String.format("%d %d %d %d %d", 
                    s.sx+1, s.sy+1, s.ex+1, s.ey+1, s.holeCount));
        }
    }
    
    // Driver
    public static void main(String args[]) {
        int m[][] = {
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}};
        
        long start = System.currentTimeMillis();
        Square s = getMostLargeSquare(m);

        if (s == null) {
            s = new Square(0, 0, 0, 0);
        }

        // print start.x start.y end.x end.y holeCount
        System.out.println(String.format("%d %d %d %d %d", 
                s.sx+1, s.sy+1, s.ex+1, s.ey+1, s.holeCount));
        System.out.println(String.format("Process time: %d msec", System.currentTimeMillis() - start));
    }
}