import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import {NavLink} from "react-router-dom";
import { fetchRealEstate, setFilter } from "../../redux/actions/realEstateActions";
import FilterRealEstate from "./FilterRealEstate";
import tableColumns from "./TableColumns";
import Alert from "../common/Alert";

function RealEstateList(props) {
    const { realEstateList, isFetching, fetchRealEstate, filter } = props;

    useEffect(() => {
        fetchRealEstate(filter);
    }, [filter, fetchRealEstate]);

    if (isFetching) {
        return (<div>IS FETCHING...</div>)
    } else {
        return (
            <div>
                <Alert {...props}/>
                <h2>Real Estate Listings</h2>
                <FilterRealEstate {...props}/>

                <NavLink to="/new" className="button">
                    Create new Real Estate
                </NavLink>

                <table>
                    <thead>
                        <tr>
                            {tableColumns.map(column => (
                                <th key={column.Header}>{column.Header}</th>
                            ))}
                        </tr>
                    </thead>
                    <tbody>
                    {realEstateList.map((element) => {
                        return (
                            <tr key={element.id}>
                                {tableColumns.map(column => (
                                    <td key={column.accessor}>{element[column.accessor]}</td>
                                ))}
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>
        );
    }
}

const mapDispatchToProps = dispatch => {
    return {
        fetchRealEstate: (filter) => dispatch(fetchRealEstate(filter)),
        setFilter: (filter) => dispatch(setFilter(filter)),
    }
};

function mapStateToProps(state) {
    const {realEstateList, isFetching, filter} = state.realEstateReducer;
    return {
        realEstateList,
        isFetching,
        filter,
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(RealEstateList);