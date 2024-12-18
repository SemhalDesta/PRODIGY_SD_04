public class Task04{
    public static boolean numInRowColumn(int[][]grid, int num, int row, int column){
        for(int i=0;i<9;i++){
            if(grid[row][i]==num||grid[i][column]==num)
            return true;
        }
        return false;
    }  
    public static boolean numInOneSquare(int [][]grid, int num, int row, int column){
        int newRow=row-row%3;
        int newColumn=column-column%3;
        for(int i=newRow; i<newRow+3; i++){
            for(int j=newColumn; j<newColumn+3; j++){
              if(grid[i][j]==num) 
                return true;
            }
        }
        return false;
    }
    public static boolean isItSafe(int [][]grid, int num, int row, int column){
        if(!(numInRowColumn(grid, num, row, column))&&!(numInOneSquare(grid, num, row, column))){
            return true;
        }
        return false;
    }
    public static boolean solver(int [][]grid){
        for(int i=0; i<9;i++){
            for(int j=0; j<9; j++){
                
                if(grid[i][j]==0){
                    
                    for(int num=1; num<=9; num++){
                        
                        if(isItSafe(grid,num,i,j)){
                            
                        grid[i][j]=num;
                        
                          if(solver(grid)){
                              
                              return true;
                          }
                          grid[i][j]=0;
                       }
                    }
                    return false;
                }
            }  
        }
        return true;
    }
    public static void printer(int [][]grid){
        for(int i=0; i<9;i++){
            if(i%3==0&&i!=0){
                System.out.println("----------------");
            }
            for(int j=0; j<9; j++){
                if(j%3==0&&j!=0){
                    System.out.print("|");
                }
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String []args){
      int [][]grid=new int[][]{
            {7, 5, 0, 0, 2, 4, 0, 0, 6},
            {0, 8, 4, 0, 0, 1, 0, 5, 9},
            {3, 6, 1, 9, 0, 5, 7, 0, 0},
            {0, 3, 2, 0, 0, 8, 0, 9, 0},
            {1, 7, 8, 6, 9, 0, 5, 4, 2},
            {6, 9, 0, 2, 4, 7, 0, 3, 8},
            {5, 2, 6, 0, 3, 0, 0, 7, 1},
            {0, 0, 3, 1, 7, 0, 0, 0, 0},
            {9, 0, 0, 4, 5, 6, 0, 8, 3}};

     System.out.println("The original grid: ");
     printer(grid);
     System.out.println();
     if(solver(grid)){
       System.out.println("The solved grid: ");
       printer(grid);
     }
     if(solver(grid)==false){
        System.out.println("Unsolvable!");
     }
    }
}