package com.company;

public class RatInAMaze {

    public boolean escape(int maze[][],int row,int column,int[][] sol){
        if (row == maze.length-1 && column == maze[0].length-1){
            sol[row][column]=1;
            return true;
        }
        if (row == maze.length || column == maze[0].length-1){
            return false;
        }

        if (isSafe(maze,row,column)){
            sol[row][column] = 1;
            if (escape(maze,row+1,column,sol)){
                return true;
            }
            if (escape(maze,row,column+1,sol)){
                return true;
            }
            sol[row][column] = 0;
            return false;
        }
        return false;
    }

    private boolean isSafe(int[][] maze, int row, int column) {
        return row >= 0 && column < maze[0].length && column >= 0 && row < maze.length && maze[row][column] == 1;
    }

    public int shortestPath(int maze[][],int startX,int startY,int endX,int endY){
        boolean vis[][] = new boolean[maze.length][maze[0].length];
        return shortestPath(maze,startX,startY,endX,endY,vis);

    }

    private int shortestPath(int[][] maze, int startX, int startY, int endX, int endY, boolean[][] vis) {
        if (startX==endX && startY == endY)
            return 0;
        if (!isValid(maze,startX,startY,vis)){
            return 100000;
        }
        vis[startX][startY] = true;
        int left = shortestPath(maze,startX,startY-1,endX,endY,vis)+1;
        int right = shortestPath(maze,startX,startY+1,endX,endY,vis)+1;
        int bottom = shortestPath(maze,startX+1,startY,endX,endY,vis)+1;
        int up = shortestPath(maze,startX-1,startY,endX,endY,vis)+1;

        vis[startX][startY] = false;

        return Math.min(Math.min(left,up),Math.min(right,bottom));
    }

    private boolean isValid(int[][] maze, int startX, int startY, boolean[][] vis) {
        return startX>=0 && startY>=0 && startX< maze.length && startY<maze[0].length && !vis[startX][startY] && maze[startX][startY] == 1;
    }


}
