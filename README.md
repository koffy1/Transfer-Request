## Transfer-Request

This project handles transfer request from a sender account to a receiver account.

There is no form of customer account taken into consideration here.

It was assumed that if you want to make a request, you input your account number, the receiver's account number and the amount in order to proceed with the transaction.

If your account is making a transfer for the first time, I assumed that you already have a balance of 50,000. So the amount you're transferring will be deducted
from this balance and you'll find your remaining balance on the balances table and the transaction on transactions table.

A transaction is considered to be duplicate if it is made within the same minute as a former transaction, to the same receiver account and paying the same amount.

If the amount to be transferred is greater than the balance, then it shows an appropriate error page.


## Set Up

Clone the project from github

#### Set up a database for the project.

The database name is transfer_request

The default user is springuser

The default password for the user is 00000000


#### Dependencies.

This is a Java project and I used Java version 11 for this work.

It is also running on spring, favoring Maven so you need to run ./mvnw spring-boot:run to build the project

To build on debug mode, run ./mvnw -X spring-boot:run instead

MySql database was used in this project
