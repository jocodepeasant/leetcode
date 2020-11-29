package 回溯算法.q37_解数独.s2;

/**
 *
 */
class Solution {
    public void solveSudoku(char[][] board) {
        //3*3
        int[] block=new int[9];
        //每一行
        int[] l=new int[9];
        //每一列
        int[] s=new int[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int temp=board[i][j]-'0';
                    block[i/3*3+j/3]+=1<<temp;
                    l[i]+=1<<temp;
                    s[j]+=1<<temp;
                }
            }
        }
        backTrack(board,0,0,l,s,block);
    }

    private boolean backTrack(char[][] board,int m,int n,int[] l,int[] s,int[] block){
        if(m>8){
            return true;
        }
        if(board[m][n]!='.'){
            if(n<8){
                if(backTrack(board,m,n+1,l,s,block)) return true;
            }else{
                if(backTrack(board,m+1,0,l,s,block)) return true;
            }
        }else{
            for(int i=1;i<10;i++){
                if((block[m/3*3+n/3]&1<<i)==1 || (l[m]&1<<i)==1 || (s[n]&1<<i)==1) continue;
                block[m/3*3+n/3]+=1<<i;
                l[m]+=1<<i;
                s[n]+=1<<i;
                board[m][n]=(char)('0'+i);
                if(n<8){
                    if(backTrack(board,m,n+1,l,s,block)) return true;
                }else{
                    if(backTrack(board,m+1,0,l,s,block)) return true;
                }
                board[m][n]='.';
                block[m/3*3+n/3]-=1<<i;
                l[m]-=1<<i;
                s[n]-=1<<i;
            }
        }
        return false;
    }

    private final int N = 9;
    private final int[] row = new int[N], col = new int[N];
    //ones数组表示0~2^9 - 1的整数中二进制表示中1的个数:如ones[7] = 3 ones[8] = 1
    //map数组表示2的整数次幂中二进制1所在位置（从0开始） 如 map[1] = 0,map[2] = 1, map[4] = 2
    private final int[] ones = new int[1 << N], map = new int[1 << N];
    private final int[][] cell = new int[3][3];

    public void solveSudoku1(char[][] board) {
        init();
        int cnt = fill_state(board);
        backtrack(cnt, board);
    }

    private void init() {
        for (int i = 0; i < N; i++) row[i] = col[i] = (1 << N) - 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cell[i][j] = (1 << N) - 1;

        // 以上2个循环把数组的数初始化为二进制表示9个1，即一开始所以格子都可填
        for (int i = 0; i < N; i++) map[1 << i] = i;

        // 对于000000000 - 111111111的每个整数，统计它们二进制表示中1的个数
        for (int i = 0; i < 1 << N; i++) {
            int n = 0;
            // 每一轮循环，都把 j 最右的1变成0，同时计数自增1
            for (int j = i; j != 0; j ^= lowBit(j)) n++;
            ones[i] = n;
        }
    }

    /**
     * 统计数独中待填的空格数
     * @param board 数独
     * @return 待填的个数
     */
    private int fill_state(char[][] board) {
        //统计board数组空格('.')的个数
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    //i,j位置为数组下标，修改对应cell的状态
                    change_state(i, j, t);
                } else
                    cnt++;
            }
        }
        return cnt;
    }

    private boolean backtrack(int cnt, char[][] board) {
        if (cnt == 0) return true;
        int min = 10, x = 0, y = 0;

        //剪枝，即找出当前所有空格可填数字个数最少的位置 记为x y
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    int k = ones[getCandidates(i, j)];
                    if (k < min) {
                        min = k;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        //遍历当前 x y所有可选数字
        for (int i = getCandidates(x, y); i != 0; i ^= lowBit(i)) {
            int t = map[lowBit(i)];

            change_state(x, y, t);
            board[x][y] = (char) ('1' + t);

            if (backtrack(cnt - 1, board)) return true;

            //恢复现场
            change_state(x, y, t);
            board[x][y] = '.';
        }
        return false;
    }

    private void change_state(int x, int y, int t) {
        row[x] ^= 1 << t;
        col[y] ^= 1 << t;
        cell[x / 3][y / 3] ^= 1 << t;
    }

    /**
     * 对维护数组x行,y列的3个集合(行、列、九宫格)进行&运算
     * 就可以获得可选数字的集合(因为我们用1标识可填数字)
     *
     * @param x 行
     * @param y 列
     * @return 可选数字的集合
     */
    private int getCandidates(int x, int y) {
        return row[x] & col[y] & cell[x / 3][y / 3];
    }

    /**
     * 求 x 二进制的最低位 1
     * @param x
     * @return
     */
    private int lowBit(int x) {
        return -x & x;
    }
}

