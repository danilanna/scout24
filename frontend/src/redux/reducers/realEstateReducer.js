import {REAL_ESTATE} from '../actions/realEstateActionTypes';
import initialState from './initialStateRealEstate';

export default function realEstateReducer(state = initialState, action) {
    switch (action.type) {
        case REAL_ESTATE.FETCH:
            return Object.assign({}, state, {
                isFetching: true,
                realEstateList: {},
                isSaved: false,
                isError: false
            });
        case REAL_ESTATE.FETCH_DONE:
            return Object.assign({}, state, {
                isFetching: false,
                realEstateList: action.realEstateList,
            });
        case REAL_ESTATE.SET_ERROR:
            return Object.assign({}, state, {
                isError: action.status,
                isFetching: false,
            });
        case REAL_ESTATE.SET_FILTER:
            return Object.assign({}, state, {
                filter: action.filter,
            });
        case REAL_ESTATE.SAVE:
            return Object.assign({}, state, {
                isFetching: true,
                realEstate: action.realEstate,
                isSaved: false,
                isError: false
            });
        case REAL_ESTATE.SAVE_DONE:
            return Object.assign({}, state, {
                realEstate: action.realEstate,
                isFetching: false,
                isSaved: true
            });
        default:
            return state;
    }
};