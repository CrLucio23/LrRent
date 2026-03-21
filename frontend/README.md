# LrRent Frontend

Frontend completo in Next.js per la piattaforma di noleggio auto LrRent.

## Stack
- Next.js App Router
- TypeScript
- CSS globale custom
- Fetch verso backend Spring Boot

## Pagine incluse
- `/` Home vetrina
- `/catalogo` Catalogo con filtri e ricerca disponibilità per date
- `/auto/[id]` Dettaglio auto con form prenotazione
- `/contatti` Pagina contatti

## Come avviarlo
1. Entra nella cartella `frontend`
2. Crea il file `.env.local`
3. Inserisci:

```env
NEXT_PUBLIC_API_BASE_URL=http://localhost:8080/api
```

4. Installa le dipendenze:

```bash
npm install
```

5. Avvia il progetto:

```bash
npm run dev
```

6. Apri `http://localhost:3000`

## Note
- Il backend Spring Boot deve essere acceso su porta `8080`.
- Se il backend usa un endpoint diverso, aggiorna `NEXT_PUBLIC_API_BASE_URL`.
- Se hai già configurato CORS nel backend per `http://localhost:3000`, il frontend funzionerà subito.
