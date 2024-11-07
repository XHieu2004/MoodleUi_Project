require('dotenv').config();
const { Sequelize } = require('sequelize');


const sequelize = new Sequelize('user_database', 'root', 'root', {
    host: 'localhost', 
    port: 3305, 
    dialect: 'mysql',
    
    
});


sequelize.authenticate()
    .then(() => {
        console.log('Connection successfully.');
    })
    .catch(err => {
        console.error('Unable to connect to database:', err);
    });


module.exports = sequelize;
