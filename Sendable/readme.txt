MSYQL Configuration
	-Since I used hibernate, the config for the database is set in persistence.xml under src/META-INF
	-the following must match in your mysql:
		*user 		= 	root
		*pass 		= 	password
		*port 		= 	3306 (3307 is the default for seneca)
		*database 	=	sendable 

		
Default Data
	-Only Cards and Categories are seeded when the application starts.
	-There are no users or any other data seeded. You have to register first.
	