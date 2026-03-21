export type Auto = {
  id: number;
  marca: string;
  modello: string;
  anno: number;
  carburante: string;
  cambio: string;
  prezzoGiornaliero: number;
  disponibile: boolean;
};

export type PrenotazioneRequest = {
  autoId: number;
  nomeCliente: string;
  cognomeCliente: string;
  emailCliente: string;
  dataInizio: string;
  dataFine: string;
};

export type ApiError = {
  timestamp?: string;
  status?: number;
  error?: string;
  message?: string;
  path?: string;
};
