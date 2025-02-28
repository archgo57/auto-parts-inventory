import React, { useEffect, useState } from 'react';
import PartList from './PartList';
import SearchFilter from './SearchFilter';

const InventoryDashboard = () => {
    const [parts, setParts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        fetch('api/parts')
            .then(response => response.json())
            .then(data => setParts(data))
            .catch(error => console.error('Error fetching parts:', error));
    }, []);

    const handleSearch = (term) => {
        setSearchTerm(term);
    };

    const filteredParts = parts.filter(part =>
        part.name.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <div>
            <h1>Inventory Dashboard</h1>
            <SearchFilter onSearch={handleSearch} />
            <PartList parts={filteredParts} />
        </div>
    );
};

export default InventoryDashboard;