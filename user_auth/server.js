const sequelize = require('./config/database');
const User = require('./models/User');

sequelize.sync()
  .then(() => console.log("Database synced"))
  .catch((error) => console.error("Error syncing database", error));

const cors = require('cors');
app.use(cors());
  

