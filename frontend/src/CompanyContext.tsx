import {createContext, ReactElement, useState} from "react";
import axios from "axios";
import {Company, dummyCompany} from "./Company";


export const CompanyProvider = createContext<{
    allCompanies: Company[],
    getAllCompanies: () => void,
    currentCompany: Company,
    getById: (id: string) => void,
}>(
    {
        currentCompany: {
            id: "",
            website: "",
            name: "",
            telephone: "",
            address: "",
            person: "",
            contacted: "",
            reminder: "",
            comment: "",
            email: ""
        },
        allCompanies: [],
        getAllCompanies: () => {},
        getById: () => {}
    })

export default function CompanyContext(props: { children: ReactElement }) {
    const [allCompanies, setAllCompanies] = useState<Company[]>([])
    const [currentCompany, setCurrentCompany] = useState<Company>(dummyCompany)


    function getAllCompanies(): void {
        axios.get("/api/company")
            .then(response => setAllCompanies(response.data))
    }

    function getCompanyById(id: string): void {
        axios.get<Company>(`/api/company/${id}`)
            .then(response => {
                setCurrentCompany(response.data)
            })
    }

    return (
        <CompanyProvider.Provider
            value={{
                allCompanies: allCompanies,
                getAllCompanies: getAllCompanies,
                getById: getCompanyById,
                currentCompany

            }}>
            {props.children}
        </CompanyProvider.Provider>

    )
}