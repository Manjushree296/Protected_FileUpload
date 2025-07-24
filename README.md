🔧 Installation
### Prerequisites
- Node.js v18+ (backend) 
- MongoDB (local or MongoDB Atlas) 
- npm or yarn    
 
### 1️⃣ Backend Setup 
 
cd server
npm install
Create .env file in /server:  
env
MONGO_URI=mongodb://localhost:27017/portfolioDB
JWT_SECRET=your_jwt_secret
Run the backend:
node server.js
Server will start on http://localhost:5000

2️⃣ Frontend Setup
cd client
npm install
Start the frontend:
npm start
Frontend runs on http://localhost:3000

✅ Technologies Used
Frontend: React.js, Axios, Bootstrap, FontAwesome
Backend: Node.js, Express.js, Mongoose, Multer
Database: MongoDB
Auth: JWT
