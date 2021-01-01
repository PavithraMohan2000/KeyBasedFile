# KeyBasedFile
File - DataStore

Build a file-based key-value data store that supports the basic CRD (create, read, and delete) operations. This data store is meant to be used as a local storage for one single process on one laptop. The data store must be exposed as a library to clients that can instantiate a class and work with the data store.

The data store will support the following functional requirements.

It can be initialized using an optional file path. If one is not provided, it will reliably create itself in a reasonable location on the laptop.
A new key-value pair can be added to the data store using the Create operation. 
If Create is invoked for an existing key, an appropriate error must be returned.
A Read operation on a key can be performed by providing the key, and receiving the value in response.
Delete operation can be performed by providing the key.
Every key supports setting a Time-To-Live property when it is created. This property is optional. If provided, it will be evaluated as an integer defining the number of days the key must be retained in the data store. Once the Time-To-Live for a key has expired,the key will no longer be available for Read or Delete operations.
Appropriate error responses must always be returned to a client if it uses the data store in unexpected ways or breaches any limits.
The data store will also support the following non-functional requirements.

Accessing DataStore CRD operations

A package named CrdOperations contains all the class required to perform CRD operations.
A class function create() can be used to create a file and add data into it.
A class function read() can be used to read a data present in the file.
A class function delete() can be used to delete a data from the file.
