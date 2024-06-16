import pkg from 'pg';

const { Pool } = pkg;

const pool = new Pool({
  user: 'postgres',
  host: 'localhost',
  database: 'hyper_aigent',
  password: '12341234',
  port: 5432,
})

async function connectToDatabase() {
  try {
    const client = await pool.connect();
    console.log("Connected to PostgreSQL");
    client.release(); // Release the client back to the pool
  } catch (error) {
    console.log(error);
    throw new Error("Could not Connect To PostgreSQL");
  }
}

async function disconnectFromDatabase() {
  try {
    await pool.end();
    console.log("Disconnected from PostgreSQL");
  } catch (error) {
    console.log(error);
    throw new Error("Could not Disconnect From PostgreSQL");
  }
}

export { connectToDatabase, disconnectFromDatabase, pool };
