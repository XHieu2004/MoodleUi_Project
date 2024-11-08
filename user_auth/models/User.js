const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const User = sequelize.define('users', {
  username: {
    type: DataTypes.STRING,
    allowNull: false,
    unique: true,
  },
  password: {
    type: DataTypes.STRING,
    allowNull: false,
  },
  phonenumber:{
    type:DataTypes.STRING,
    allowNull: false,
  },
  email:{
    type:DataTypes.STRING,
    allowNull: false,
  },
  dob:{
    type:DataTypes.STRING,
    allowNull:false,
  },
  address:{
    type: DataTypes.STRING,
    allowNull:false,
  },
  role: {
    type: DataTypes.STRING,
    allowNull: false,
    defaultValue: 'student', 
  }
});

module.exports = User;
