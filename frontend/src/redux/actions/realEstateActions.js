import {REAL_ESTATE} from './realEstateActionTypes';
import RealEstateApi from "../api/realEstateApi";

function loadRealEstate() {
    return {type: REAL_ESTATE.FETCH};
}

function loaded(realEstateList) {
    return {type: REAL_ESTATE.FETCH_DONE, realEstateList: realEstateList};
}

export function setError(status) {
    return {type: REAL_ESTATE.SET_ERROR, status: status};
}

export function setFilter(filter) {
    return {type: REAL_ESTATE.SET_FILTER, filter: filter};
}

function saved(realEstate) {
    return {type: REAL_ESTATE.SAVE_DONE, realEstate: realEstate};
}

function save(realEstate) {
    return {type: REAL_ESTATE.SAVE, realEstate: realEstate};
}

export function fetchRealEstate(filter) {
    return dispatch => {
        dispatch(loadRealEstate());
        return RealEstateApi.getRealEstateList(filter).then(realEstateList => {
            dispatch(loaded(realEstateList));
        }).catch(() => {
            dispatch(setError(true));
        });
    };
}

export function saveRealEstate(realEstate) {
    return dispatch => {
        dispatch(save(realEstate));
        return RealEstateApi.saveRealEstate(realEstate).then(resp => {
            dispatch(saved(resp));
        }).catch(() => {
            dispatch(setError(true));
        });
    };
}