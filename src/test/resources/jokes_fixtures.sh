curl -v -i -XPUT http://localhost:10018/riak/publications/20130728_regular -H "Content-Type: application/json" -d '{"author_name":"albert",
"author_mail":"albert@jokinette.com", "publication_date":"28/07/2013", "category":"regular", "joke_content":"No doubt, this is a really good joke"}'
curl -v -i -XPUT http://localhost:10018/riak/publications/20130730_regular -H "Content-Type: application/json" -d '{"author_name":"albert",
"author_mail":"albert@jokinette.com", "publication_date":"28/07/2013", "category":"regular", "joke_content":"No doubt, this is a really good joke"}'
curl -v -i -XPUT http://localhost:10018/riak/publications/20130729_regular -H "Content-Type: application/json" -d '{"author_name":"albert",
"author_mail":"albert@jokinette.com", "publication_date":"28/07/2013", "category":"regular", "joke_content":"No doubt, this is a really good joke"}'
curl -v -i -XPUT http://localhost:10018/riak/publications/20130804_regular -H "Content-Type: application/json" -d '{"author_name":"albert",
"author_mail":"albert@jokinette.com", "publication_date":"04/08/2013", "category":"regular", "joke_content":"No doubt, this is a really good joke"}'