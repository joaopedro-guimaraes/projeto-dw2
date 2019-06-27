export interface EmpresaCadastroModel {
    userCompany: {
        idUser: number;
    },
    cnpj: string;
    companyName: string;
    address: string;
    number: number,
    city: string;
    neighborhood: string;
    state: string;
    cep: number;
    telephone: number;
    responsible: string;
}
