import React, {useState, useEffect} from "react";
import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import "./Calendar.css";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import AddEventForm from "./AddEvent";

const MyCalendar = () => {
    const [events, setEvents] = useState([{}]);

    const getEvents = () => {
        axios.get(`http://localhost:8080/api/${localStorage.getItem("userID")}/events`).then((res) => {
            setEvents(res.data.map((event) => {
                return {
                    id: event.id, 
                    description: event.description, 
                    title: event.title, 
                    start: (event.startDate), 
                    end: (event.endDate)
                }
            }))
        })
    }

    // get request
    useEffect(() => {
        getEvents();
    }, [])

    const navigate = useNavigate();
    // update an event => put/delete request
    function handleEventClick(info) {
        localStorage.setItem("eventID", info.event.id);
        localStorage.setItem("eventDescription", info.event.description);
        localStorage.setItem("eventTitle", info.event.title);
        localStorage.setItem("eventStartDate", info.event.startDate);
        localStorage.setItem("eventEndDate", info.event.startDate);
        navigate("/updateEvent");
    }
    
    return (
    <div className="app-container">
        <div className="formContainer">
            <AddEventForm></AddEventForm>
        </div>
        <div className="notes-grid">
            <div className="note-item">
                    <FullCalendar plugins={[ dayGridPlugin ]} weekends={true} events={events} 
                    eventClick={handleEventClick} 
                    />
            </div>
        </div>
    </div>
    );
}



export default MyCalendar;