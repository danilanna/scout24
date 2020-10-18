import * as React from 'react';

export default function FilterRealEstate(props) {
    const { filter } = props;

    return (
        <div>
            <input
                type="checkbox"
                checked={filter}
                onChange={() => props.setFilter(!filter)}
                id="filter"
            />
            <label htmlFor="filter">Filter Real Estates price between 400 EUR and 600 EUR</label>
        </div>
    );
}
