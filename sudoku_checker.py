#Python program to check if a Sudoku board is solved.
#Takes 2D-array board as input and outputs True(board is
#solved) or False(board is not solved).

def solved(board):
    #rows
    for row in board:
        if not complete(row):
            return False
    #columns
    for col in range(9):
        column = []
        for row in range(9):
            column.append(board[row][col])
        if not complete(column):
            return False
    #squares
    for row in range(0,9,3):
        for col in range(0,9,3):
            if not complete(make_square(row,col,board)):
                return False
    return True

def make_square(row, col, board):
    square = []
    for i in range(3):
        for j in range(3):
            square.append(board[row+i][col+j])
    return square

def complete(numbers):
    reference = [False] * 10
    for n in numbers:
        if n<1 or n>9:
            return False
        if reference[n]:
            return False
        reference[n] = True
    return True


board = [[5,3,4,6,7,8,9,1,2],[6,7,2,1,9,5,3,4,8],[1,9,8,3,4,2,5,6,7],[8,5,9,7,6,1,4,2,3],\
[4,2,6,8,5,3,7,9,1],[7,1,3,9,2,4,8,5,6],[9,6,1,5,3,7,2,8,4],[2,8,7,4,1,9,6,3,5],[3,4,5,2,8,6,1,7,9]]

print(solved(board))
