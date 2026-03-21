import { ApiError, Auto, PrenotazioneRequest } from '@/lib/types';

const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL ?? 'http://localhost:8080/api';

async function parseResponse<T>(response: Response): Promise<T> {
  if (!response.ok) {
    let message = 'Errore durante la richiesta';

    try {
      const data = (await response.json()) as ApiError;
      message = data.message || data.error || message;
    } catch {
      message = response.statusText || message;
    }

    throw new Error(message);
  }

  return response.json() as Promise<T>;
}

export async function getAutoList(): Promise<Auto[]> {
  const response = await fetch(`${API_BASE_URL}/auto`, { cache: 'no-store' });
  return parseResponse<Auto[]>(response);
}

export async function getAutoById(id: string | number): Promise<Auto> {
  const response = await fetch(`${API_BASE_URL}/auto/${id}`, { cache: 'no-store' });
  return parseResponse<Auto>(response);
}

export async function getAvailableAuto(dataInizio: string, dataFine: string): Promise<Auto[]> {
  const params = new URLSearchParams({ dataInizio, dataFine });
  const response = await fetch(`${API_BASE_URL}/auto/disponibili?${params.toString()}`, {
    cache: 'no-store',
  });

  return parseResponse<Auto[]>(response);
}

export async function getFilteredAuto(filters: {
  disponibile?: boolean;
  carburante?: string;
  prezzoMax?: string;
}): Promise<Auto[]> {
  const params = new URLSearchParams();

  if (typeof filters.disponibile === 'boolean') {
    params.set('disponibile', String(filters.disponibile));
  }

  if (filters.carburante) {
    params.set('carburante', filters.carburante);
  }

  if (filters.prezzoMax) {
    params.set('prezzoMax', filters.prezzoMax);
  }

  const endpoint = params.toString()
    ? `${API_BASE_URL}/auto/filter?${params.toString()}`
    : `${API_BASE_URL}/auto`;

  const response = await fetch(endpoint, { cache: 'no-store' });
  return parseResponse<Auto[]>(response);
}

export async function createPrenotazione(payload: PrenotazioneRequest) {
  const response = await fetch(`${API_BASE_URL}/prenotazioni`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(payload),
  });

  return parseResponse(response);
}
