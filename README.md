TODO
- [ ] application state kept in memory
- [ ] on application start load data from .json and store it in database
- [ ] on application start state is loaded from database and then updated from kafka topics [markets, events]
- [ ] initial state load can adapt to different data source (redis, postgres, mysql, filesystem...)
- [ ] expose offer service to get app state (events) via http endpoint
- [ ] endpoint should accept filter for upcoming events by their start date
- [ ] listen for kafka topic _markets_ and update app state in memory
- [ ] listen for kafka topic _events_ and update app state in memory
- [ ] started events should be periodically removed from app state