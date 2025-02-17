A very simple setup showcasing the use of Testcontainers with ActiveMQ broker

**Note:** I noticed that in some real life scenarios it doesn't work if the containter setup is inherited from the base class. You need to have the setup directly inside the test class. I'm not sure why that is.
