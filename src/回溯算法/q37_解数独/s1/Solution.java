package 回溯算法.q37_解数独.s1;

/**
 * 未优化，普通回溯
 */
class Solution {
    public void solveSudoku(char[][] board) {
        //3*3
        boolean[][] block=new boolean[9][10];
        //每一行
        boolean[][] l=new boolean[9][10];
        //每一列
        boolean[][] s=new boolean[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int temp=board[i][j]-'0';
                    block[i/3*3+j/3][temp]=true;
                    l[i][temp]=true;
                    s[j][temp]=true;
                }
            }
        }
        backTrack(board,0,0,l,s,block);
    }

    private boolean backTrack(char[][] board,int m,int n,boolean[][] l,boolean[][] s,boolean[][] block){
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
                if(block[m/3*3+n/3][i] || l[m][i] || s[n][i]) continue;
                block[m/3*3+n/3][i]=true;
                l[m][i]=true;
                s[n][i]=true;
                board[m][n]=(char)('0'+i);
                if(n<8){
                    if(backTrack(board,m,n+1,l,s,block)) return true;
                }else{
                    if(backTrack(board,m+1,0,l,s,block)) return true;
                }
                board[m][n]='.';
                block[m/3*3+n/3][i]=false;
                l[m][i]=false;
                s[n][i]=false;
            }
        }
        return false;
    }
}
