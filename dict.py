import time, sys, re

def dictAtt(argv):
    start = time.time()
    count = 0
    file = open("words.txt", "r")
    words = file.read().splitlines()

    for i in words:
        if i in argv.lower(): 
            print("The word ", i, " is in ", argv, ", we recommend not using words in your password as it makes it more suscepitble to a dictionary attack")
            count = count + 1
    end =  time.time()
    print("Execution time in seconds: ",(end-start))
    print("Number of words contained in your password: ",count)

if __name__ == "__main__":
    dictAtt(sys.argv[1:])