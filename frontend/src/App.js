
import './App.css';
import Calendar from './Calendar';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import UpdateEventForm from './UpdateEvent';
import SignIn from './Login';
import SignUp from './SignUp';
import MyProfile from './UserProfile';

function App() {

  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<SignIn />}></Route>
      <Route path="/signup" element={<SignUp />}></Route>
      <Route path="/userProfile"></Route>
      <Route path="/calendar" element={<Calendar />}> </Route>
      <Route path="/updateEvent" element={<UpdateEventForm />}></Route>
      <Route path="/viewUserProfile" element={<MyProfile />}></Route>
    </Routes>
    </BrowserRouter>
  );
}

export default App;
