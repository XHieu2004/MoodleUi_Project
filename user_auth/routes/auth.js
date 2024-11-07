const express = require('express');
const router = express.Router();
const authController = require('../controllers/authController');
const healthcheck = require('../controllers/healthcheckController');

router.post('/register', authController.register);
router.post('/login', authController.login);
router.post('/logout', authController.logout);
router.get("/abc",healthcheck.thinhdan );

module.exports = router;
