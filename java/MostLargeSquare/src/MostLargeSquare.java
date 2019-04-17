/**
 * author: haeram27@gmail.com
 * 
 * ����> MostLargeSqure include some 0
 * 
 * ���� 1) �־��� ��ľȿ��� ���� ū Square(���簢��)�� ã�ƶ�.
 * ���� 2) Square�� 0�� 1�� ���Ϸθ� ���� �� �� �ִ�. 
 * ���� 3) ����1�� ����2�� �����ϴ� ���� ũ���� ���簢���� ���� �� ��� 
 *       ���� ���� ã�� Square�� �켱�̰�
 *       ���� ���� �� �� 0�� ���� Square�� �ִٸ� 0�� ���� Square�� �켱�ȴ�.
 * ���� 4) ����� ���� ������ ��Ŀ��� start point�� x,y���� end point�� x,y ���̴�.
 *       ���� ����� ��16 ��12�� �迭�̶�� 
 *       ���� ������ ���ϴ� ��ġ�� ��ǥ (x,y)�� (1,1)�̰� 
 *       ���� ������ �ֻ�� ��ġ�� ��ǥ (x,y)�� (16,12) �̴�.
 * ���� 5) ����Ϸ� �ð��� 1���̳�
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