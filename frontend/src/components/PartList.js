import React, { useEffect, useState } from 'react';

const PartList = () => {
    const [parts, setParts] = useState([]);

    useEffect(() => {
        const username = 'user'; // Replace with your username
        const password = 'password'; // Replace with your password
        const headers = new Headers();
        headers.set('Authorization', 'Basic ' + btoa(username + ":" + password));

        fetch('http://localhost:8081/api/parts', { headers: headers })
            .then(response => response.json())
            .then(data => {
                console.log('Fetched parts:', data); // Log the fetched data
                setParts(data);
            })
            .catch(error => console.error('Error fetching parts:', error));
    }, []);

    return (
        <div>
            <h1>Parts List</h1>
            <ul>
                {parts.map(part => (
                    <li key={part.id}>{part.name} - {part.description} - ${part.price}</li>
                ))}
            </ul>
        </div>
    );
};

export default PartList;