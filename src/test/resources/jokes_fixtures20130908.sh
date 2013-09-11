curl -v -i -XPUT http://localhost:10018/riak/publications/20130728_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130729",
"authorName":"albert", "authorMail":"albert@jokinette.com", "publicationDate":"28/07/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'

curl -v -i -XPUT http://localhost:10018/riak/publications/20130729_regular -H "Content-Type: application/json" -d '{"previousJokeDate":"20130728","nextJokeDate":"20130730",
"authorName":"albert","authorMail":"albert@jokinette.com", "publicationDate":"29/07/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'

curl -v -i -XPUT http://localhost:10018/riak/publications/20130730_regular -H "Content-Type: application/json" -d '{"previousJokeDate":"20130729", "nextJokeDate":"20130804",
"authorName":"albert","authorMail":"albert@jokinette.com", "publicationDate":"30/07/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'

curl -v -i -XPUT http://localhost:10018/riak/publications/20130804_regular -H "Content-Type: application/json" -d '{"previousJokeDate":"20130730","authorName":"albert",
"authorMail":"albert@jokinette.com", "publicationDate":"04/08/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'