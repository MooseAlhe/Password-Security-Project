# Password-Security-Project

## passwordStrength.java

###### Setup
1. Download the files from this GitHub onto your PC. This can work on any desktop platform
2. If you want to change the text file that is used, or even use one that is not included in this repository, put the file into the same folder as the program and change the file name in the 'dictAtt()' method to the name of the file. Right now the file in use is engmix.txt
3. Open your terminal and navigate to the folder where the program is located
4. Type 'javac passwordStrength.java'
5. Then type 'java passwordStrenth'


It should prompt you to the following output:

```
Welcome to Password Strength Generator 
 In this program, we will take in some information, as well as your password, and give reccomendations to make your password the most optimal it can be 
Some guidelines for your password:
1. Password must conatain at least 8 characters
2. The password must contain letters
3. The password is reccomended to use a mix of lowercase/uppercase letters, digits, and special characters
4. We recommend making you password as random as possible, and try not to use words in your password
5. We strongly recommend not using any personal information in your password e.g. your name
6. All of these algorithms are independent of each other. Your password might be strong against a brute force attack but not necessarily strong against a dictionary attack
Enter your first name: 
Mustafa
Enter your last name: 
Alhelawe
Now Enter your password: 
#strong45Alh 
Here is the strength of your password with respect to Brute Force Attacks: 
This is a Strong Password 
 Entropy: 78.65506622013166
Here are some recomendations for your password with respect to Dictionary Attacks: 
Your password, #strong45Alh contains a word, ron, to make your password the most optimal against Dictionary Attacks, we recommend to not use any words in your password
Your password, #strong45Alh contains a word, strong, to make your password the most optimal against Dictionary Attacks, we recommend to not use any words in your password
Here are some recomendations for you password based on your personal information: 
Your password contains an abreviation of your last name, alh, we recommend not putting any variations of your name into your password
```

## dict.py

This is my failed attempt to create the dictAtt() method into Python. 
