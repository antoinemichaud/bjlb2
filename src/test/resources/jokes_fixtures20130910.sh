curl -v -i -XPUT http://localhost:10018/riak/publications/20130908_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130909", "previousJokeDate":"20130907","authorName":"boloss",
"authorMail":"boloss@jokinette.com", "publicationDate":"08/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130909_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130910", "previousJokeDate":"20130908","authorName":"Nico",
"authorMail":"boloss@jokinette.com", "publicationDate":"09/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130910_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130911", "previousJokeDate":"20130909","authorName":"Antoine",
"authorMail":"antoineo@jokinette.com", "publicationDate":"10/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130911_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130912", "previousJokeDate":"20130910","authorName":"paulo",
"authorMail":"paulo@jokinette.com", "publicationDate":"11/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130912_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130913", "previousJokeDate":"20130911","authorName":"vivi",
"authorMail":"vivi@jokinette.com", "publicationDate":"12/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130913_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130914", "previousJokeDate":"20130912","authorName":"tivi",
"authorMail":"tivi@jokinette.com", "publicationDate":"13/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130914_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130915", "previousJokeDate":"20130913","authorName":"Tutu",
"authorMail":"tutu@jokinette.com", "publicationDate":"14/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130915_regular -H "Content-Type: application/json" -d '{"nextJokeDate":"20130916", "previousJokeDate":"20130914","authorName":"Tusoeur",
"authorMail":"tasoeur@jokinette.com", "publicationDate":"15/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'


curl -v -i -XPUT http://localhost:10018/riak/publications/20130916_regular -H "Content-Type: application/json" -d '{"previousJokeDate":"20130915","authorName":"Tonperer",
"authorMail":"tonpere@jokinette.com", "publicationDate":"16/09/2013", "category":"regular", "jokeContent":"No doubt, this is a really good joke"}'