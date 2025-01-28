The spring boot application uses the DelegatingFilterProxy filter to secure the application as it is mapped to all the api's.


It Bootstraps the security whenever a request is sent to the application it passes through the filter and the filter has many internal filters that provide specific functionality.

Image

Authentication Mechanism

after the request is sent through the filter we are providing it to AuthenticationManager.
AuthenticationManager will take input as authentication object with credentials,
and it gives the output as an authentication object with Principal.

In turn AuthenticationManager has authenticate() method. which provides the authentication object to AuthenticationProvider which has 2 methods - authenticate() and supports()
using the supports method manager finds the correct provider for the credentials given in authentication object.

Then the AuthenticationProvider uses the UserDetailService object with method loadByUserName() to get the UserDetails object from DB/any other.
After this, it authenticates and provides the Authentication with Principal.


JWT AUTHENTICATION

The idea behind it is to create a standard way for two parties to communicate securely.
Open industry standard specification called RFC 7519.

Focuses on authorization
addition to JWT there are more Authorization strategies 
using tokens
-> Session token ---> Reference tokens
-> Json web token (jwt) ---> Value tokens

Previously we used session id as a reference and stored in cookies So that 
for every subsequent request we passed the session id automatically in headers.
(Session Id + Cookies)
Here server creates a session and keeps track of it itself and session id is the reference to lookup 
from the session that user sends in header.

Problems 
It assumes only one monolithic single server hosting the web app. But nowadays we have a load balancer which 
directs the request to servers.

This was resolved by introducing a shared session cache (Redis) and store all the session data in it.
But this approach directly depends on Redis instance availability.

This was resolved by using a sticky session pattern instead of using Redis, So the load balancer always 
redirects to the server which received the first request. But this approach also not very much scalable,
and we cannot use this with microservices.

This was resolved by using Json Tokens exchanged over web.
- Here we are passing the whole user info inside the token with a unique signature.
- So everytime client makes a subsequent request, the client sends the whole JSON token with the request.
- Token is not an id anymore it is the JSON object which has all the user info.

Structure of JWT Token

header.payload.signature 
--> Header is the info of Algorithm and type (jwt)
--> Payload is the user info (authenticated user) that we want to pass to server.
--> Signature is the combination of header+payload decoded using the a secret.

